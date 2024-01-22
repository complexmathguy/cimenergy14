import React, { Component } from 'react'
import MechLoad1Service from '../services/MechLoad1Service';

class UpdateMechLoad1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateMechLoad1 = this.updateMechLoad1.bind(this);

    }

    componentDidMount(){
        MechLoad1Service.getMechLoad1ById(this.state.id).then( (res) =>{
            let mechLoad1 = res.data;
            this.setState({
            });
        });
    }

    updateMechLoad1 = (e) => {
        e.preventDefault();
        let mechLoad1 = {
            mechLoad1Id: this.state.id,
        };
        console.log('mechLoad1 => ' + JSON.stringify(mechLoad1));
        console.log('id => ' + JSON.stringify(this.state.id));
        MechLoad1Service.updateMechLoad1(mechLoad1).then( res => {
            this.props.history.push('/mechLoad1s');
        });
    }


    cancel(){
        this.props.history.push('/mechLoad1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update MechLoad1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateMechLoad1}>Save</button>
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

export default UpdateMechLoad1Component
