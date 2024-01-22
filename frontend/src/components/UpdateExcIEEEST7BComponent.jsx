import React, { Component } from 'react'
import ExcIEEEST7BService from '../services/ExcIEEEST7BService';

class UpdateExcIEEEST7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                oelin: '',
                uelin: ''
        }
        this.updateExcIEEEST7B = this.updateExcIEEEST7B.bind(this);

        this.changeOelinHandler = this.changeOelinHandler.bind(this);
        this.changeUelinHandler = this.changeUelinHandler.bind(this);
    }

    componentDidMount(){
        ExcIEEEST7BService.getExcIEEEST7BById(this.state.id).then( (res) =>{
            let excIEEEST7B = res.data;
            this.setState({
                oelin: excIEEEST7B.oelin,
                uelin: excIEEEST7B.uelin
            });
        });
    }

    updateExcIEEEST7B = (e) => {
        e.preventDefault();
        let excIEEEST7B = {
            excIEEEST7BId: this.state.id,
            oelin: this.state.oelin,
            uelin: this.state.uelin
        };
        console.log('excIEEEST7B => ' + JSON.stringify(excIEEEST7B));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEST7BService.updateExcIEEEST7B(excIEEEST7B).then( res => {
            this.props.history.push('/excIEEEST7Bs');
        });
    }

    changeOelinHandler= (event) => {
        this.setState({oelin: event.target.value});
    }
    changeUelinHandler= (event) => {
        this.setState({uelin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEST7Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEST7B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Oelin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Uelin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEST7B}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateExcIEEEST7BComponent
