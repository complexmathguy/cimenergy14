import React, { Component } from 'react'
import ExcANSService from '../services/ExcANSService';

class UpdateExcANSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcANS = this.updateExcANS.bind(this);

    }

    componentDidMount(){
        ExcANSService.getExcANSById(this.state.id).then( (res) =>{
            let excANS = res.data;
            this.setState({
            });
        });
    }

    updateExcANS = (e) => {
        e.preventDefault();
        let excANS = {
            excANSId: this.state.id,
        };
        console.log('excANS => ' + JSON.stringify(excANS));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcANSService.updateExcANS(excANS).then( res => {
            this.props.history.push('/excANSs');
        });
    }


    cancel(){
        this.props.history.push('/excANSs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcANS</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcANS}>Save</button>
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

export default UpdateExcANSComponent
