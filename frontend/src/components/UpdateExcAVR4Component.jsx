import React, { Component } from 'react'
import ExcAVR4Service from '../services/ExcAVR4Service';

class UpdateExcAVR4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcAVR4 = this.updateExcAVR4.bind(this);

    }

    componentDidMount(){
        ExcAVR4Service.getExcAVR4ById(this.state.id).then( (res) =>{
            let excAVR4 = res.data;
            this.setState({
            });
        });
    }

    updateExcAVR4 = (e) => {
        e.preventDefault();
        let excAVR4 = {
            excAVR4Id: this.state.id,
        };
        console.log('excAVR4 => ' + JSON.stringify(excAVR4));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAVR4Service.updateExcAVR4(excAVR4).then( res => {
            this.props.history.push('/excAVR4s');
        });
    }


    cancel(){
        this.props.history.push('/excAVR4s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAVR4</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAVR4}>Save</button>
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

export default UpdateExcAVR4Component
