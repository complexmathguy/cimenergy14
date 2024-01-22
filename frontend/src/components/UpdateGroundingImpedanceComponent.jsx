import React, { Component } from 'react'
import GroundingImpedanceService from '../services/GroundingImpedanceService';

class UpdateGroundingImpedanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGroundingImpedance = this.updateGroundingImpedance.bind(this);

    }

    componentDidMount(){
        GroundingImpedanceService.getGroundingImpedanceById(this.state.id).then( (res) =>{
            let groundingImpedance = res.data;
            this.setState({
            });
        });
    }

    updateGroundingImpedance = (e) => {
        e.preventDefault();
        let groundingImpedance = {
            groundingImpedanceId: this.state.id,
        };
        console.log('groundingImpedance => ' + JSON.stringify(groundingImpedance));
        console.log('id => ' + JSON.stringify(this.state.id));
        GroundingImpedanceService.updateGroundingImpedance(groundingImpedance).then( res => {
            this.props.history.push('/groundingImpedances');
        });
    }


    cancel(){
        this.props.history.push('/groundingImpedances');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GroundingImpedance</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGroundingImpedance}>Save</button>
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

export default UpdateGroundingImpedanceComponent
