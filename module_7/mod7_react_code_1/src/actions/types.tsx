import { Action } from "redux";

interface CryptoCurrency {
  readonly symbol : string;
  readonly name : string;
}

export interface Position {
  readonly cryptoCurrency: CryptoCurrency;
  readonly quantity : number;
  readonly value : number;
}

export interface PortfolioState {
  readonly positions : Position[];
  readonly isAuthenticated?: boolean;
}

export interface AuthenticationState {
  readonly isAuthenticated: boolean;
  readonly username: string;
}

export interface Transaction {
  id: string,
  symbol: string,
  transactionType: string,
  quantity: number,
  price: number
}

export interface TransactionsState {
  readonly transactions: Transaction[]
  readonly isAuthenticated?: boolean;
}

export interface GettingPositionsAction extends Action<'GettingPositions'> {};

export interface GotPositionsAction extends Action<'GotPositions'>{
  positions : Position[];
  isAuthenticated: boolean;
}

export interface AddQueryAction extends Action<'AddQuery'> {
  subject : string;
  content : string;
}

export interface GetPortfolioTransactionsAction extends Action<'GetTransactions'> {
  transactionSymbol ?: string;
}

export interface GotPortfolioTransactionsAction extends Action<'GotTransactions'> {
  transactions: Transaction[];
  isAuthenticated: boolean;
}

export interface AddPortfolioTransaction extends Action<'AddTransaction'> {
  cryptoSymbol: string;
  quantity: number;
  price: number;
  transactionType: string;
}

export interface LoginAction extends Action<'Login'>{
    username: string;
    password: string;
}

export interface LogoutAction extends Action<'Logout'>{
}

export interface DeletePortfolioTransactions extends Action<'DeleteTransactions'> {
  transactionIds: string[]
}

export type PortfolioActions = GettingPositionsAction | GotPositionsAction | AddPortfolioTransaction;
export type PortfolioTransactionsAction = GetPortfolioTransactionsAction | GotPortfolioTransactionsAction;
