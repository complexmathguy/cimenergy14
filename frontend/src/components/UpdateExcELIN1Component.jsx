import React, { Component } from 'react'
import ExcELIN1Service from '../services/ExcELIN1Service';

class UpdateExcELIN1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcELIN1 = this.updateExcELIN1.bind(this);

    }

    componentDidMount(){
        ExcELIN1Service.getExcELIN1ById(this.state.id).then( (res) =>{
            let excELIN1 = res.data;
            this.setState({
            });
        });
    }

    updateExcELIN1 = (e) => {
        e.preventDefault();
        let excELIN1 = {
            excELIN1Id: this.state.id,
        };
        console.log('excELIN1 => ' + JSON.stringify(excELIN1));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcELIN1Service.updateExcELIN1(excELIN1).then( res => {
            this.props.history.push('/excELIN1s');
        });
    }


    cancel(){
        this.props.history.push('/excELIN1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcELIN1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcELIN1}>Save</button>
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

export default UpdateExcELIN1Component
