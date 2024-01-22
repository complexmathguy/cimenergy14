import React, { Component } from 'react'
import ExcIEEEAC3AService from '../services/ExcIEEEAC3AService';

class UpdateExcIEEEAC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEAC3A = this.updateExcIEEEAC3A.bind(this);

    }

    componentDidMount(){
        ExcIEEEAC3AService.getExcIEEEAC3AById(this.state.id).then( (res) =>{
            let excIEEEAC3A = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEAC3A = (e) => {
        e.preventDefault();
        let excIEEEAC3A = {
            excIEEEAC3AId: this.state.id,
        };
        console.log('excIEEEAC3A => ' + JSON.stringify(excIEEEAC3A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEAC3AService.updateExcIEEEAC3A(excIEEEAC3A).then( res => {
            this.props.history.push('/excIEEEAC3As');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEAC3As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEAC3A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEAC3A}>Save</button>
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

export default UpdateExcIEEEAC3AComponent
