import React, { Component } from 'react'
import ExcAVR5Service from '../services/ExcAVR5Service';

class UpdateExcAVR5Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcAVR5 = this.updateExcAVR5.bind(this);

    }

    componentDidMount(){
        ExcAVR5Service.getExcAVR5ById(this.state.id).then( (res) =>{
            let excAVR5 = res.data;
            this.setState({
            });
        });
    }

    updateExcAVR5 = (e) => {
        e.preventDefault();
        let excAVR5 = {
            excAVR5Id: this.state.id,
        };
        console.log('excAVR5 => ' + JSON.stringify(excAVR5));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAVR5Service.updateExcAVR5(excAVR5).then( res => {
            this.props.history.push('/excAVR5s');
        });
    }


    cancel(){
        this.props.history.push('/excAVR5s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAVR5</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAVR5}>Save</button>
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

export default UpdateExcAVR5Component
