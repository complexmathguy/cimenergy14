import React, { Component } from 'react'
import ExcIEEEDC2AService from '../services/ExcIEEEDC2AService';

class UpdateExcIEEEDC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEDC2A = this.updateExcIEEEDC2A.bind(this);

    }

    componentDidMount(){
        ExcIEEEDC2AService.getExcIEEEDC2AById(this.state.id).then( (res) =>{
            let excIEEEDC2A = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEDC2A = (e) => {
        e.preventDefault();
        let excIEEEDC2A = {
            excIEEEDC2AId: this.state.id,
        };
        console.log('excIEEEDC2A => ' + JSON.stringify(excIEEEDC2A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEDC2AService.updateExcIEEEDC2A(excIEEEDC2A).then( res => {
            this.props.history.push('/excIEEEDC2As');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEDC2As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEDC2A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEDC2A}>Save</button>
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

export default UpdateExcIEEEDC2AComponent
