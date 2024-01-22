import React, { Component } from 'react'
import ExcAVR1Service from '../services/ExcAVR1Service';

class UpdateExcAVR1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcAVR1 = this.updateExcAVR1.bind(this);

    }

    componentDidMount(){
        ExcAVR1Service.getExcAVR1ById(this.state.id).then( (res) =>{
            let excAVR1 = res.data;
            this.setState({
            });
        });
    }

    updateExcAVR1 = (e) => {
        e.preventDefault();
        let excAVR1 = {
            excAVR1Id: this.state.id,
        };
        console.log('excAVR1 => ' + JSON.stringify(excAVR1));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAVR1Service.updateExcAVR1(excAVR1).then( res => {
            this.props.history.push('/excAVR1s');
        });
    }


    cancel(){
        this.props.history.push('/excAVR1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAVR1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAVR1}>Save</button>
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

export default UpdateExcAVR1Component
