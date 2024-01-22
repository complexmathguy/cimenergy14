import React, { Component } from 'react'
import ExcELIN2Service from '../services/ExcELIN2Service';

class UpdateExcELIN2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcELIN2 = this.updateExcELIN2.bind(this);

    }

    componentDidMount(){
        ExcELIN2Service.getExcELIN2ById(this.state.id).then( (res) =>{
            let excELIN2 = res.data;
            this.setState({
            });
        });
    }

    updateExcELIN2 = (e) => {
        e.preventDefault();
        let excELIN2 = {
            excELIN2Id: this.state.id,
        };
        console.log('excELIN2 => ' + JSON.stringify(excELIN2));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcELIN2Service.updateExcELIN2(excELIN2).then( res => {
            this.props.history.push('/excELIN2s');
        });
    }


    cancel(){
        this.props.history.push('/excELIN2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcELIN2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcELIN2}>Save</button>
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

export default UpdateExcELIN2Component
