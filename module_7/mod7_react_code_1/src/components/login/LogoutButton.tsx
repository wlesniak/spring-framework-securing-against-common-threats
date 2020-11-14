import * as React from 'react';
import { ThunkDispatch } from 'redux-thunk';
import { LogoutAction } from '../../actions/types';
import { logoutActionCreator } from '../../actions/protfolioActions';
import {connect} from 'react-redux';

interface LogoutFormProps {
    logout?: Function;
}


class LogoutButton extends React.Component<LogoutFormProps, any> {

    constructor(props:LogoutFormProps) {
        super(props);
        this.handleSubmit=this.handleSubmit.bind(this);
    }

    handleSubmit(e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();
        if(this.props.logout !== undefined) {
            this.props.logout();
        }
    }

  public render() {
    return (
        <form onSubmit={this.handleSubmit}>
   				<button name="logoutFormBtn" type="submit">Logout</button>               
        </form>
    );
  }
}

const mapDispatchToProps = (dispatch : ThunkDispatch<{},{},any>) => ({
    logout: (credentials: LogoutAction, history: History) => dispatch(logoutActionCreator())
  });

export default connect(null,mapDispatchToProps)(LogoutButton);
