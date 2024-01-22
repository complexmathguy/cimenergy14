import React, { Component } from 'react'
import ExcAVR3Service from '../services/ExcAVR3Service';

class UpdateExcAVR3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcAVR3 = this.updateExcAVR3.bind(this);

    }

    componentDidMount(){
        ExcAVR3Service.getExcAVR3ById(this.state.id).then( (res) =>{
            let excAVR3 = res.data;
            this.setState({
            });
        });
    }

    updateExcAVR3 = (e) => {
        e.preventDefault();
        let excAVR3 = {
            excAVR3Id: this.state.id,
        };
        console.log('excAVR3 => ' + JSON.stringify(excAVR3));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAVR3Service.updateExcAVR3(excAVR3).then( res => {
            this.props.history.push('/excAVR3s');
        });
    }


    cancel(){
        this.props.history.push('/excAVR3s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAVR3</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAVR3}>Save</button>
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

export default UpdateExcAVR3Component
