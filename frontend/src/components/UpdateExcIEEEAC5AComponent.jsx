import React, { Component } from 'react'
import ExcIEEEAC5AService from '../services/ExcIEEEAC5AService';

class UpdateExcIEEEAC5AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEAC5A = this.updateExcIEEEAC5A.bind(this);

    }

    componentDidMount(){
        ExcIEEEAC5AService.getExcIEEEAC5AById(this.state.id).then( (res) =>{
            let excIEEEAC5A = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEAC5A = (e) => {
        e.preventDefault();
        let excIEEEAC5A = {
            excIEEEAC5AId: this.state.id,
        };
        console.log('excIEEEAC5A => ' + JSON.stringify(excIEEEAC5A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEAC5AService.updateExcIEEEAC5A(excIEEEAC5A).then( res => {
            this.props.history.push('/excIEEEAC5As');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEAC5As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEAC5A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEAC5A}>Save</button>
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

export default UpdateExcIEEEAC5AComponent
