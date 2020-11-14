import * as React from 'react';

interface LoginFormProps {
    login?: Function;
}

class LoginForm extends React.Component<LoginFormProps, any> {

    constructor(props:LoginFormProps) {
        super(props);

        this.handleSubmit=this.handleSubmit.bind(this);
    }

    handleSubmit(e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();
        window.location.reload();
    }

  public render() {
    return (
        <div className="container add_trans_div">
            <form onSubmit={this.handleSubmit}>
				    <button name="loginFormBtn" type="submit">Login</button>               
            </form>
	    </div>
    );
  }
}

export default LoginForm;
