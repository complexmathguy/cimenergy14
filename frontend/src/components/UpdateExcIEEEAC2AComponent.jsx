import React, { Component } from 'react'
import ExcIEEEAC2AService from '../services/ExcIEEEAC2AService';

class UpdateExcIEEEAC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEAC2A = this.updateExcIEEEAC2A.bind(this);

    }

    componentDidMount(){
        ExcIEEEAC2AService.getExcIEEEAC2AById(this.state.id).then( (res) =>{
            let excIEEEAC2A = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEAC2A = (e) => {
        e.preventDefault();
        let excIEEEAC2A = {
            excIEEEAC2AId: this.state.id,
        };
        console.log('excIEEEAC2A => ' + JSON.stringify(excIEEEAC2A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEAC2AService.updateExcIEEEAC2A(excIEEEAC2A).then( res => {
            this.props.history.push('/excIEEEAC2As');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEAC2As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEAC2A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEAC2A}>Save</button>
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

export default UpdateExcIEEEAC2AComponent
