import React, { Component } from 'react'
import ExcIEEEST3AService from '../services/ExcIEEEST3AService';

class UpdateExcIEEEST3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEST3A = this.updateExcIEEEST3A.bind(this);

    }

    componentDidMount(){
        ExcIEEEST3AService.getExcIEEEST3AById(this.state.id).then( (res) =>{
            let excIEEEST3A = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEST3A = (e) => {
        e.preventDefault();
        let excIEEEST3A = {
            excIEEEST3AId: this.state.id,
        };
        console.log('excIEEEST3A => ' + JSON.stringify(excIEEEST3A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEST3AService.updateExcIEEEST3A(excIEEEST3A).then( res => {
            this.props.history.push('/excIEEEST3As');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEST3As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEST3A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEST3A}>Save</button>
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

export default UpdateExcIEEEST3AComponent
