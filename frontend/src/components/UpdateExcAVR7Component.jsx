import React, { Component } from 'react'
import ExcAVR7Service from '../services/ExcAVR7Service';

class UpdateExcAVR7Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcAVR7 = this.updateExcAVR7.bind(this);

    }

    componentDidMount(){
        ExcAVR7Service.getExcAVR7ById(this.state.id).then( (res) =>{
            let excAVR7 = res.data;
            this.setState({
            });
        });
    }

    updateExcAVR7 = (e) => {
        e.preventDefault();
        let excAVR7 = {
            excAVR7Id: this.state.id,
        };
        console.log('excAVR7 => ' + JSON.stringify(excAVR7));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAVR7Service.updateExcAVR7(excAVR7).then( res => {
            this.props.history.push('/excAVR7s');
        });
    }


    cancel(){
        this.props.history.push('/excAVR7s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAVR7</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAVR7}>Save</button>
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

export default UpdateExcAVR7Component
