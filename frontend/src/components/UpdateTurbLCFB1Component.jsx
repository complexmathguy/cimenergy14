import React, { Component } from 'react'
import TurbLCFB1Service from '../services/TurbLCFB1Service';

class UpdateTurbLCFB1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateTurbLCFB1 = this.updateTurbLCFB1.bind(this);

    }

    componentDidMount(){
        TurbLCFB1Service.getTurbLCFB1ById(this.state.id).then( (res) =>{
            let turbLCFB1 = res.data;
            this.setState({
            });
        });
    }

    updateTurbLCFB1 = (e) => {
        e.preventDefault();
        let turbLCFB1 = {
            turbLCFB1Id: this.state.id,
        };
        console.log('turbLCFB1 => ' + JSON.stringify(turbLCFB1));
        console.log('id => ' + JSON.stringify(this.state.id));
        TurbLCFB1Service.updateTurbLCFB1(turbLCFB1).then( res => {
            this.props.history.push('/turbLCFB1s');
        });
    }


    cancel(){
        this.props.history.push('/turbLCFB1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TurbLCFB1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTurbLCFB1}>Save</button>
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

export default UpdateTurbLCFB1Component
