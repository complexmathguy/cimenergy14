import React, { Component } from 'react'
import ExcIEEEDC3AService from '../services/ExcIEEEDC3AService';

class UpdateExcIEEEDC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEDC3A = this.updateExcIEEEDC3A.bind(this);

    }

    componentDidMount(){
        ExcIEEEDC3AService.getExcIEEEDC3AById(this.state.id).then( (res) =>{
            let excIEEEDC3A = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEDC3A = (e) => {
        e.preventDefault();
        let excIEEEDC3A = {
            excIEEEDC3AId: this.state.id,
        };
        console.log('excIEEEDC3A => ' + JSON.stringify(excIEEEDC3A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEDC3AService.updateExcIEEEDC3A(excIEEEDC3A).then( res => {
            this.props.history.push('/excIEEEDC3As');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEDC3As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEDC3A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEDC3A}>Save</button>
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

export default UpdateExcIEEEDC3AComponent
