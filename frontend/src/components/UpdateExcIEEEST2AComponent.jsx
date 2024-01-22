import React, { Component } from 'react'
import ExcIEEEST2AService from '../services/ExcIEEEST2AService';

class UpdateExcIEEEST2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEST2A = this.updateExcIEEEST2A.bind(this);

    }

    componentDidMount(){
        ExcIEEEST2AService.getExcIEEEST2AById(this.state.id).then( (res) =>{
            let excIEEEST2A = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEST2A = (e) => {
        e.preventDefault();
        let excIEEEST2A = {
            excIEEEST2AId: this.state.id,
        };
        console.log('excIEEEST2A => ' + JSON.stringify(excIEEEST2A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEST2AService.updateExcIEEEST2A(excIEEEST2A).then( res => {
            this.props.history.push('/excIEEEST2As');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEST2As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEST2A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEST2A}>Save</button>
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

export default UpdateExcIEEEST2AComponent
