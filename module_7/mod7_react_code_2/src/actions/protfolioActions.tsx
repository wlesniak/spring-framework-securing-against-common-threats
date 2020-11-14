import axios from "axios";
import {GotPositionsAction, PortfolioState,AddPortfolioTransaction, GotPortfolioTransactionsAction, Transaction, DeletePortfolioTransactions, LoginAction, LogoutAction} from "./types";
import { ActionCreator, Dispatch } from "redux";
import { ThunkAction, ThunkDispatch } from "redux-thunk";

const PORTFOLIO_SERVICE_DOMAIN = "http://localhost:8080/api";

export const getPortfolioPositionsCreator: ActionCreator<
ThunkAction<
    void,
    undefined,
    null,
    GotPositionsAction
    >
> = () => {
    return async (dispatch : Dispatch) => {
            const response = await axios.get(PORTFOLIO_SERVICE_DOMAIN+'/portfolio');
            const portfolioState : PortfolioState = response.data;
            const gotPositionsAction : GotPositionsAction = {
                type : "GotPositions",
                positions: portfolioState.positions,
                isAuthenticated: true
            };  
            dispatch(gotPositionsAction);
        
    };
};

export const getPortfolioPositionsLogoutCreator: ActionCreator<
ThunkAction<
    void,
    undefined,
    null,
    GotPositionsAction
    >
> = () => {
    return async (dispatch : Dispatch) => {
            const gotPositionsAction : GotPositionsAction = {
                type : "GotPositions",
                positions: [],
                isAuthenticated: false
            };  
            dispatch(gotPositionsAction);
        
    };
};

export const getPortfolioTransactionsCreator: ActionCreator<
    ThunkAction<
        void,
        undefined,
        null,
        GotPortfolioTransactionsAction
    >
> = (transactionType : string = "") => {
    return async (dispatch : Dispatch) => {
            const header = {'Authorization': 'Basic ' +""};
            const response = await axios.get(PORTFOLIO_SERVICE_DOMAIN+'/portfolio/transactions/'+transactionType,
            {headers: header});
            const transactionsList : Transaction[] = response.data;
            const gotTransactionsAction : GotPortfolioTransactionsAction = {
                type: 'GotTransactions',
                transactions : transactionsList,
                isAuthenticated : true
            }
            dispatch(gotTransactionsAction)
        } 
}

export const addPortfolioTransactionCreator : ActionCreator<
    ThunkAction<
        void,
        undefined,
        null,
        AddPortfolioTransaction
    >
    > = (transaction: AddPortfolioTransaction) => {
        return async (dispatch :  ThunkDispatch<{},{},any>) => {
                const response = await axios.post(PORTFOLIO_SERVICE_DOMAIN+'/portfolio/transactions', transaction);
                dispatch(getPortfolioPositionsCreator());
            
        }
    }

    export const loginActionCreator : ActionCreator<
    ThunkAction<
        void,
        undefined,
        null,
        LoginAction
    >
    > = (loginAction: LoginAction) => {
        return async (dispatch :  ThunkDispatch<{},{},any>) => {
                var authRequest = new FormData();
                authRequest.append("username",loginAction.username);
                authRequest.append("password",loginAction.password);
                const response = await axios.post(PORTFOLIO_SERVICE_DOMAIN+'/login', authRequest,  {headers: {'Content-Type': 'multipart/form-data' } });
                dispatch(getPortfolioPositionsCreator());
            
        }
    }

    export const logoutActionCreator : ActionCreator<
    ThunkAction<
        void,
        undefined,
        null,
        LoginAction
    >
    > = (logoutAction: LogoutAction) => {
        return async (dispatch :  ThunkDispatch<{},{},any>) => {
                const response = await axios.post(PORTFOLIO_SERVICE_DOMAIN+'/logout', logoutAction);
                dispatch(getPortfolioPositionsLogoutCreator());          
        }
        
    }



export const deleteTransactionsCreator : ActionCreator<
    ThunkAction<
        void,
        undefined,
        null,
        DeletePortfolioTransactions
    >
> = (transactionIds : string[]) => {
    return async (dispatch :  ThunkDispatch<{},{},any>) => {

            const response = await axios.delete(PORTFOLIO_SERVICE_DOMAIN+'/portfolio/transactions',{data: {id: transactionIds}})
            dispatch(getPortfolioTransactionsCreator());
            dispatch(getPortfolioPositionsCreator());
        
    }
}
