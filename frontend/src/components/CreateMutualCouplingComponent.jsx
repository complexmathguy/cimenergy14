import React, { Component } from 'react'
import MutualCouplingService from '../services/MutualCouplingService';

class CreateMutualCouplingComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            MutualCouplingService.getMutualCouplingById(this.state.id).then( (res) =>{
                let mutualCoupling = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateMutualCoupling = (e) => {
        e.preventDefault();
        let mutualCoupling = {
                mutualCouplingId: this.state.id,
            };
        console.log('mutualCoupling => ' + JSON.stringify(mutualCoupling));

        // step 5
        if(this.state.id === '_add'){
            mutualCoupling.mutualCouplingId=''
            MutualCouplingService.createMutualCoupling(mutualCoupling).then(res =>{
                this.props.history.push('/mutualCouplings');
            });
        }else{
            MutualCouplingService.updateMutualCoupling(mutualCoupling).then( res => {
                this.props.history.push('/mutualCouplings');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/mutualCouplings');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add MutualCoupling</h3>
        }else{
            return <h3 className="text-center">Update MutualCoupling</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateMutualCoupling}>Save</button>
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

export default CreateMutualCouplingComponent
