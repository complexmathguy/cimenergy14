import React, { Component } from 'react'
import Pss1Service from '../services/Pss1Service';

class UpdatePss1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePss1 = this.updatePss1.bind(this);

    }

    componentDidMount(){
        Pss1Service.getPss1ById(this.state.id).then( (res) =>{
            let pss1 = res.data;
            this.setState({
            });
        });
    }

    updatePss1 = (e) => {
        e.preventDefault();
        let pss1 = {
            pss1Id: this.state.id,
        };
        console.log('pss1 => ' + JSON.stringify(pss1));
        console.log('id => ' + JSON.stringify(this.state.id));
        Pss1Service.updatePss1(pss1).then( res => {
            this.props.history.push('/pss1s');
        });
    }


    cancel(){
        this.props.history.push('/pss1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Pss1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePss1}>Save</button>
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

export default UpdatePss1Component
