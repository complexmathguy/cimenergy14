import React, { Component } from 'react'
import GroundingImpedanceService from '../services/GroundingImpedanceService';

class CreateGroundingImpedanceComponent extends Component {
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
            GroundingImpedanceService.getGroundingImpedanceById(this.state.id).then( (res) =>{
                let groundingImpedance = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGroundingImpedance = (e) => {
        e.preventDefault();
        let groundingImpedance = {
                groundingImpedanceId: this.state.id,
            };
        console.log('groundingImpedance => ' + JSON.stringify(groundingImpedance));

        // step 5
        if(this.state.id === '_add'){
            groundingImpedance.groundingImpedanceId=''
            GroundingImpedanceService.createGroundingImpedance(groundingImpedance).then(res =>{
                this.props.history.push('/groundingImpedances');
            });
        }else{
            GroundingImpedanceService.updateGroundingImpedance(groundingImpedance).then( res => {
                this.props.history.push('/groundingImpedances');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/groundingImpedances');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GroundingImpedance</h3>
        }else{
            return <h3 className="text-center">Update GroundingImpedance</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGroundingImpedance}>Save</button>
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

export default CreateGroundingImpedanceComponent
