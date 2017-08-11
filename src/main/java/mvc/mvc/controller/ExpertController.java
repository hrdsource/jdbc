package mvc.mvc.controller;

import java.util.List;

import mvc.mvc.model.dao.ExpertDao;
import mvc.mvc.model.dto.Expert;
import mvc.mvc.view.ExpertView;

public class ExpertController {

	private Expert model;
	private List<Expert> list;
	private ExpertDao dao;
	private ExpertView view;
	
	public ExpertController(){
		dao=new ExpertDao();
		view=new ExpertView();
	}
	
	public void updateExpertView(){
	
		model=dao.getExpert(4);
		view.updateExpertView(model);
	}
	
	public void updateAllExperts(){
		list=dao.getExperts();
		view.updateAllExperts(list);
	}
	
}
