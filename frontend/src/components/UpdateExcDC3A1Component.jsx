import React, { Component } from 'react'
import ExcDC3A1Service from '../services/ExcDC3A1Service';

class UpdateExcDC3A1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcDC3A1 = this.updateExcDC3A1.bind(this);

    }

    componentDidMount(){
        ExcDC3A1Service.getExcDC3A1ById(this.state.id).then( (res) =>{
            let excDC3A1 = res.data;
            this.setState({
            });
        });
    }

    updateExcDC3A1 = (e) => {
        e.preventDefault();
        let excDC3A1 = {
            excDC3A1Id: this.state.id,
        };
        console.log('excDC3A1 => ' + JSON.stringify(excDC3A1));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcDC3A1Service.updateExcDC3A1(excDC3A1).then( res => {
            this.props.history.push('/excDC3A1s');
        });
    }


    cancel(){
        this.props.history.push('/excDC3A1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcDC3A1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcDC3A1}>Save</button>
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

export default UpdateExcDC3A1Component
