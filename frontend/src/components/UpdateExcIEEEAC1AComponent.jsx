import React, { Component } from 'react'
import ExcIEEEAC1AService from '../services/ExcIEEEAC1AService';

class UpdateExcIEEEAC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEAC1A = this.updateExcIEEEAC1A.bind(this);

    }

    componentDidMount(){
        ExcIEEEAC1AService.getExcIEEEAC1AById(this.state.id).then( (res) =>{
            let excIEEEAC1A = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEAC1A = (e) => {
        e.preventDefault();
        let excIEEEAC1A = {
            excIEEEAC1AId: this.state.id,
        };
        console.log('excIEEEAC1A => ' + JSON.stringify(excIEEEAC1A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEAC1AService.updateExcIEEEAC1A(excIEEEAC1A).then( res => {
            this.props.history.push('/excIEEEAC1As');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEAC1As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEAC1A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEAC1A}>Save</button>
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

export default UpdateExcIEEEAC1AComponent
