import React, { Component } from 'react'
import ExcAC2AService from '../services/ExcAC2AService';

class UpdateExcAC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcAC2A = this.updateExcAC2A.bind(this);

    }

    componentDidMount(){
        ExcAC2AService.getExcAC2AById(this.state.id).then( (res) =>{
            let excAC2A = res.data;
            this.setState({
            });
        });
    }

    updateExcAC2A = (e) => {
        e.preventDefault();
        let excAC2A = {
            excAC2AId: this.state.id,
        };
        console.log('excAC2A => ' + JSON.stringify(excAC2A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAC2AService.updateExcAC2A(excAC2A).then( res => {
            this.props.history.push('/excAC2As');
        });
    }


    cancel(){
        this.props.history.push('/excAC2As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAC2A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAC2A}>Save</button>
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

export default UpdateExcAC2AComponent
