import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSingleTodoFormComponent } from './add-single-todo-form.component';

describe('AddSingleTodoFormComponent', () => {
  let component: AddSingleTodoFormComponent;
  let fixture: ComponentFixture<AddSingleTodoFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddSingleTodoFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSingleTodoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
