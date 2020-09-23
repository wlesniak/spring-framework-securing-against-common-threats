package com.pluralsight.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pluralsight.security.model.AddTransactionToPortfolioDto;
import com.pluralsight.security.model.DeleteTransactionsDto;
import com.pluralsight.security.service.PortfolioCommandService;

@Controller
public class PortfolioCommandController {

	private final PortfolioCommandService commandService;
	
	public PortfolioCommandController(PortfolioCommandService commandService) {
		this.commandService = commandService;
	}

	@PostMapping("/portfolio/transactions")
	public ModelAndView addTransactionToPortfolio(@ModelAttribute("transaction") AddTransactionToPortfolioDto request) {
		commandService.addTransactionToPortfolio(request);
		return new ModelAndView("redirect:/portfolio");
	}
	
	@DeleteMapping("/portfolio/transactions")
	public ModelAndView deleteTransactionFromPortfolio(@ModelAttribute("selected") DeleteTransactionsDto request) {
		for(String id : request.getId()) {
			commandService.removeTransactionFromPortfolio(id);
		}
		return new ModelAndView("redirect:/portfolio");
	}
	
}
