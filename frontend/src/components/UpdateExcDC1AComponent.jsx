import React, { Component } from 'react'
import ExcDC1AService from '../services/ExcDC1AService';

class UpdateExcDC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcDC1A = this.updateExcDC1A.bind(this);

    }

    componentDidMount(){
        ExcDC1AService.getExcDC1AById(this.state.id).then( (res) =>{
            let excDC1A = res.data;
            this.setState({
            });
        });
    }

    updateExcDC1A = (e) => {
        e.preventDefault();
        let excDC1A = {
            excDC1AId: this.state.id,
        };
        console.log('excDC1A => ' + JSON.stringify(excDC1A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcDC1AService.updateExcDC1A(excDC1A).then( res => {
            this.props.history.push('/excDC1As');
        });
    }


    cancel(){
        this.props.history.push('/excDC1As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcDC1A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcDC1A}>Save</button>
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

export default UpdateExcDC1AComponent
