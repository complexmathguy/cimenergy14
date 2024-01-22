import React, { Component } from 'react'
import ExcIEEEST1AService from '../services/ExcIEEEST1AService';

class UpdateExcIEEEST1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                uelin: ''
        }
        this.updateExcIEEEST1A = this.updateExcIEEEST1A.bind(this);

        this.changeUelinHandler = this.changeUelinHandler.bind(this);
    }

    componentDidMount(){
        ExcIEEEST1AService.getExcIEEEST1AById(this.state.id).then( (res) =>{
            let excIEEEST1A = res.data;
            this.setState({
                uelin: excIEEEST1A.uelin
            });
        });
    }

    updateExcIEEEST1A = (e) => {
        e.preventDefault();
        let excIEEEST1A = {
            excIEEEST1AId: this.state.id,
            uelin: this.state.uelin
        };
        console.log('excIEEEST1A => ' + JSON.stringify(excIEEEST1A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEST1AService.updateExcIEEEST1A(excIEEEST1A).then( res => {
            this.props.history.push('/excIEEEST1As');
        });
    }

    changeUelinHandler= (event) => {
        this.setState({uelin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEST1As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEST1A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Uelin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEST1A}>Save</button>
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

export default UpdateExcIEEEST1AComponent
