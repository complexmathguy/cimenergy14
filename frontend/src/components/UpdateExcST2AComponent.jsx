import React, { Component } from 'react'
import ExcST2AService from '../services/ExcST2AService';

class UpdateExcST2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcST2A = this.updateExcST2A.bind(this);

    }

    componentDidMount(){
        ExcST2AService.getExcST2AById(this.state.id).then( (res) =>{
            let excST2A = res.data;
            this.setState({
            });
        });
    }

    updateExcST2A = (e) => {
        e.preventDefault();
        let excST2A = {
            excST2AId: this.state.id,
        };
        console.log('excST2A => ' + JSON.stringify(excST2A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcST2AService.updateExcST2A(excST2A).then( res => {
            this.props.history.push('/excST2As');
        });
    }


    cancel(){
        this.props.history.push('/excST2As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcST2A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcST2A}>Save</button>
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

export default UpdateExcST2AComponent
