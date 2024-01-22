import React, { Component } from 'react'
import MutualCouplingService from '../services/MutualCouplingService';

class UpdateMutualCouplingComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateMutualCoupling = this.updateMutualCoupling.bind(this);

    }

    componentDidMount(){
        MutualCouplingService.getMutualCouplingById(this.state.id).then( (res) =>{
            let mutualCoupling = res.data;
            this.setState({
            });
        });
    }

    updateMutualCoupling = (e) => {
        e.preventDefault();
        let mutualCoupling = {
            mutualCouplingId: this.state.id,
        };
        console.log('mutualCoupling => ' + JSON.stringify(mutualCoupling));
        console.log('id => ' + JSON.stringify(this.state.id));
        MutualCouplingService.updateMutualCoupling(mutualCoupling).then( res => {
            this.props.history.push('/mutualCouplings');
        });
    }


    cancel(){
        this.props.history.push('/mutualCouplings');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update MutualCoupling</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateMutualCoupling}>Save</button>
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

export default UpdateMutualCouplingComponent
