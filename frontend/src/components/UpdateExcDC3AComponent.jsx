import React, { Component } from 'react'
import ExcDC3AService from '../services/ExcDC3AService';

class UpdateExcDC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcDC3A = this.updateExcDC3A.bind(this);

    }

    componentDidMount(){
        ExcDC3AService.getExcDC3AById(this.state.id).then( (res) =>{
            let excDC3A = res.data;
            this.setState({
            });
        });
    }

    updateExcDC3A = (e) => {
        e.preventDefault();
        let excDC3A = {
            excDC3AId: this.state.id,
        };
        console.log('excDC3A => ' + JSON.stringify(excDC3A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcDC3AService.updateExcDC3A(excDC3A).then( res => {
            this.props.history.push('/excDC3As');
        });
    }


    cancel(){
        this.props.history.push('/excDC3As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcDC3A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcDC3A}>Save</button>
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

export default UpdateExcDC3AComponent
