import {combineReducers} from "redux";
import { portfolioReducer, portfolioTransactionsReducer} from "./portfolioReducer";
import {PortfolioState, TransactionsState} from '../actions/types'

export interface ApplicationState {
    portfolio : PortfolioState;
    portfolioTransactions : TransactionsState;
}

export default combineReducers<ApplicationState>({
    portfolio:portfolioReducer,
    portfolioTransactions: portfolioTransactionsReducer
});


