import * as React from 'react';
import { ThunkDispatch } from 'redux-thunk';
import { LoginAction } from '../../actions/types';
import { loginActionCreator } from '../../actions/protfolioActions';
import {connect} from 'react-redux';

interface LoginFormProps {
    login?: Function;
}


class LoginForm extends React.Component<LoginFormProps, any> {

    constructor(props:LoginFormProps) {
        super(props);
        this.state = {
           username: "",
            password: ""
        }
        this.onChange=this.onChange.bind(this);
        this.handleSubmit=this.handleSubmit.bind(this);
    }

    handleSubmit(e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();
        const credentials = {
            username: this.state.username,
            password: this.state.password
        };
        if(this.props.login !== undefined) {
            this.props.login(credentials);
        }
    }

    onChange(e: React.ChangeEvent<HTMLInputElement>) {
        this.setState({ [e.target.name]: e.target.value});
    }

  public render() {
    return (
        <div className="container add_trans_div">
            <form onSubmit={this.handleSubmit}>
                <label>Username</label> 
				<input type="text" name="username" required={true} value={this.state.username} onChange={this.onChange}/>
                <label>Password</label> 
				<input type="password" name="password" required={true} value={this.state.password} onChange={this.onChange}/>
				<button name="loginFormBtn" type="submit">Login</button>               
            </form>
	    </div>
    );
  }
}
const mapDispatchToProps = (dispatch : ThunkDispatch<{},{},any>) => ({
    login: (credentials: LoginAction, history: History) => dispatch(loginActionCreator(credentials, history))
  });

export default connect(null,mapDispatchToProps)(LoginForm);
