import React, { Component } from 'react'
import WindGenType4IECService from '../services/WindGenType4IECService';

class UpdateWindGenType4IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindGenType4IEC = this.updateWindGenType4IEC.bind(this);

    }

    componentDidMount(){
        WindGenType4IECService.getWindGenType4IECById(this.state.id).then( (res) =>{
            let windGenType4IEC = res.data;
            this.setState({
            });
        });
    }

    updateWindGenType4IEC = (e) => {
        e.preventDefault();
        let windGenType4IEC = {
            windGenType4IECId: this.state.id,
        };
        console.log('windGenType4IEC => ' + JSON.stringify(windGenType4IEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindGenType4IECService.updateWindGenType4IEC(windGenType4IEC).then( res => {
            this.props.history.push('/windGenType4IECs');
        });
    }


    cancel(){
        this.props.history.push('/windGenType4IECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindGenType4IEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindGenType4IEC}>Save</button>
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

export default UpdateWindGenType4IECComponent
