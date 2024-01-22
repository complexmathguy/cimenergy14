import React, { Component } from 'react'
import ExcAVR2Service from '../services/ExcAVR2Service';

class UpdateExcAVR2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcAVR2 = this.updateExcAVR2.bind(this);

    }

    componentDidMount(){
        ExcAVR2Service.getExcAVR2ById(this.state.id).then( (res) =>{
            let excAVR2 = res.data;
            this.setState({
            });
        });
    }

    updateExcAVR2 = (e) => {
        e.preventDefault();
        let excAVR2 = {
            excAVR2Id: this.state.id,
        };
        console.log('excAVR2 => ' + JSON.stringify(excAVR2));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAVR2Service.updateExcAVR2(excAVR2).then( res => {
            this.props.history.push('/excAVR2s');
        });
    }


    cancel(){
        this.props.history.push('/excAVR2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAVR2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAVR2}>Save</button>
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

export default UpdateExcAVR2Component
