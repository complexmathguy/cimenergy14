import React, { Component } from 'react'
import Pss5Service from '../services/Pss5Service';

class UpdatePss5Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePss5 = this.updatePss5.bind(this);

    }

    componentDidMount(){
        Pss5Service.getPss5ById(this.state.id).then( (res) =>{
            let pss5 = res.data;
            this.setState({
            });
        });
    }

    updatePss5 = (e) => {
        e.preventDefault();
        let pss5 = {
            pss5Id: this.state.id,
        };
        console.log('pss5 => ' + JSON.stringify(pss5));
        console.log('id => ' + JSON.stringify(this.state.id));
        Pss5Service.updatePss5(pss5).then( res => {
            this.props.history.push('/pss5s');
        });
    }


    cancel(){
        this.props.history.push('/pss5s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Pss5</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePss5}>Save</button>
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

export default UpdatePss5Component
