package com.pluralsight.security.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pluralsight.security.model.AddTransactionToPortfolioDto;
import com.pluralsight.security.model.DeleteTransactionsDto;
import com.pluralsight.security.model.ListTransactionsDto;
import com.pluralsight.security.model.PortfolioPositionsDto;
import com.pluralsight.security.model.TransactionDetailsDto;
import com.pluralsight.security.service.PortfolioCommandService;
import com.pluralsight.security.service.PortfolioQueryService;

@RestController
@RequestMapping("api")
public class PortfolioController {

	private final PortfolioQueryService portfolioService;
	private final PortfolioCommandService commandService;
	
	public PortfolioController(PortfolioQueryService portfolioService, PortfolioCommandService commandService) {
		this.portfolioService = portfolioService;
		this.commandService = commandService;
	}

	@GetMapping(value = {"/portfolio","/portfolio/{portfolioId}"})
	public PortfolioPositionsDto portfolioPositions(@AuthenticationPrincipal Principal principal) {
		String username = principal.getName();
		return portfolioService.getPortfolioPositionsForUser(username);
	}
	
	@RequestMapping(method=RequestMethod.HEAD,value="/portfolio")
	public ResponseEntity<?> userPortfolioExists(@AuthenticationPrincipal Principal principal) {
		if(this.portfolioService.userHasAportfolio(principal.getName())) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = {"/portfolio/transactions","/portfolio/transactions/{symbol}"})
	public List<TransactionDetailsDto> getTransactionDetails(@PathVariable Optional<String> symbol, @AuthenticationPrincipal Principal principal) {
		String username = principal.getName();
		ListTransactionsDto transactions = portfolioService.getPortfolioTransactionsForUser(username);
		if(symbol.isPresent()) {
			return  transactions.getTransactions().stream().filter(trans -> symbol.get().equals(trans.getSymbol())).collect(Collectors.toList());
		} 
		return transactions.getTransactions();
	}
	
	@PostMapping("/portfolio/transactions")
	public void addTransactionToPortfolio(@RequestBody AddTransactionToPortfolioDto request,@AuthenticationPrincipal Principal principal) {
		String username = principal.getName();
		request.setUsername(username);
		commandService.addTransactionToPortfolio(request);
	}
	
	@DeleteMapping("/portfolio/transactions")
	public void deleteTransactionFromPortfolio(@RequestBody DeleteTransactionsDto request, @AuthenticationPrincipal Principal principal) {
		String username = principal.getName();
		for(String id: request.getId()) {
			commandService.removeTransactionFromPortfolio(username,id);
		}
	}
	
	@PutMapping("/portfolio")
	public void createPortfolio(@AuthenticationPrincipal Principal principal) {
		String username = principal.getName();
		if(!this.portfolioService.userHasAportfolio(username)) {
			this.commandService.createNewPortfolio(username);
		}
	}
	
}
