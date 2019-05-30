package com.damian.todo_Final;



import com.damian.todo_Final.dao.ITodosRepository;
import com.damian.todo_Final.entities.Todos;
import com.damian.todo_Final.services.ITodosService;
import com.damian.todo_Final.services.ItodosImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;



import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = TodoFinalApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
// @WebMvcTest
public class TodoFinalApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;



	@LocalServerPort
	private int port;

	private String getRootUrl() {
			return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}



	@Test
	public void getAllTodos() {

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/employees",
				HttpMethod.GET, entity, String.class);
		assertNotNull(response.getBody());

	}

	@Test
	public void createNewTodo() {

		Todos todo = new Todos();
		todo.setId(5);
		todo.setTaskDate("15.01.1990");
		todo.setTaskStatus(true);
		todo.setTaskDescritpion("Description for testing");

		ResponseEntity<Todos> postResponse = restTemplate.postForEntity(getRootUrl() + "/todos", todo, Todos.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());

	}

	@Test
	public void testUpdateTodo() {
		int id = 1;
		Todos todo = restTemplate.getForObject(getRootUrl() + "/todos/" + id, Todos.class);
		todo.setTaskDate("15.01.1990");
		todo.setTaskStatus(true);
		todo.setTaskDescritpion("Updating");
		restTemplate.put(getRootUrl() + "/todos/" + id, todo);
		Todos updatedTodo = restTemplate.getForObject(getRootUrl() + "/todos/" + id, Todos.class);
		assertNotNull(updatedTodo);


	}


	@Test
	public void testDeletedTodo() {
		int id = 3;
		Todos todo = restTemplate.getForObject(getRootUrl() + "/todos/" + id, Todos.class);
		assertNotNull(todo);
		restTemplate.delete(getRootUrl() + "/todos/" + id);
		try {
			todo = restTemplate.getForObject(getRootUrl() + "/todos/" + id, Todos.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}




}













