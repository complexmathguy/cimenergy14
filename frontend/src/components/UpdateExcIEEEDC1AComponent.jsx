import React, { Component } from 'react'
import ExcIEEEDC1AService from '../services/ExcIEEEDC1AService';

class UpdateExcIEEEDC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEDC1A = this.updateExcIEEEDC1A.bind(this);

    }

    componentDidMount(){
        ExcIEEEDC1AService.getExcIEEEDC1AById(this.state.id).then( (res) =>{
            let excIEEEDC1A = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEDC1A = (e) => {
        e.preventDefault();
        let excIEEEDC1A = {
            excIEEEDC1AId: this.state.id,
        };
        console.log('excIEEEDC1A => ' + JSON.stringify(excIEEEDC1A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEDC1AService.updateExcIEEEDC1A(excIEEEDC1A).then( res => {
            this.props.history.push('/excIEEEDC1As');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEDC1As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEDC1A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEDC1A}>Save</button>
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

export default UpdateExcIEEEDC1AComponent
