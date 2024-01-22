import React, { Component } from 'react'
import ExcIEEEAC4AService from '../services/ExcIEEEAC4AService';

class UpdateExcIEEEAC4AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEAC4A = this.updateExcIEEEAC4A.bind(this);

    }

    componentDidMount(){
        ExcIEEEAC4AService.getExcIEEEAC4AById(this.state.id).then( (res) =>{
            let excIEEEAC4A = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEAC4A = (e) => {
        e.preventDefault();
        let excIEEEAC4A = {
            excIEEEAC4AId: this.state.id,
        };
        console.log('excIEEEAC4A => ' + JSON.stringify(excIEEEAC4A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEAC4AService.updateExcIEEEAC4A(excIEEEAC4A).then( res => {
            this.props.history.push('/excIEEEAC4As');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEAC4As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEAC4A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEAC4A}>Save</button>
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

export default UpdateExcIEEEAC4AComponent
