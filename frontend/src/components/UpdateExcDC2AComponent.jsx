import React, { Component } from 'react'
import ExcDC2AService from '../services/ExcDC2AService';

class UpdateExcDC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcDC2A = this.updateExcDC2A.bind(this);

    }

    componentDidMount(){
        ExcDC2AService.getExcDC2AById(this.state.id).then( (res) =>{
            let excDC2A = res.data;
            this.setState({
            });
        });
    }

    updateExcDC2A = (e) => {
        e.preventDefault();
        let excDC2A = {
            excDC2AId: this.state.id,
        };
        console.log('excDC2A => ' + JSON.stringify(excDC2A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcDC2AService.updateExcDC2A(excDC2A).then( res => {
            this.props.history.push('/excDC2As');
        });
    }


    cancel(){
        this.props.history.push('/excDC2As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcDC2A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcDC2A}>Save</button>
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

export default UpdateExcDC2AComponent
