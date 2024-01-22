import React, { Component } from 'react'
import ExcIEEEDC4BService from '../services/ExcIEEEDC4BService';

class UpdateExcIEEEDC4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEDC4B = this.updateExcIEEEDC4B.bind(this);

    }

    componentDidMount(){
        ExcIEEEDC4BService.getExcIEEEDC4BById(this.state.id).then( (res) =>{
            let excIEEEDC4B = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEDC4B = (e) => {
        e.preventDefault();
        let excIEEEDC4B = {
            excIEEEDC4BId: this.state.id,
        };
        console.log('excIEEEDC4B => ' + JSON.stringify(excIEEEDC4B));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEDC4BService.updateExcIEEEDC4B(excIEEEDC4B).then( res => {
            this.props.history.push('/excIEEEDC4Bs');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEDC4Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEDC4B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEDC4B}>Save</button>
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

export default UpdateExcIEEEDC4BComponent
