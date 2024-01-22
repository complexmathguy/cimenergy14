import React, { Component } from 'react'
import ExcST4BService from '../services/ExcST4BService';

class UpdateExcST4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcST4B = this.updateExcST4B.bind(this);

    }

    componentDidMount(){
        ExcST4BService.getExcST4BById(this.state.id).then( (res) =>{
            let excST4B = res.data;
            this.setState({
            });
        });
    }

    updateExcST4B = (e) => {
        e.preventDefault();
        let excST4B = {
            excST4BId: this.state.id,
        };
        console.log('excST4B => ' + JSON.stringify(excST4B));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcST4BService.updateExcST4B(excST4B).then( res => {
            this.props.history.push('/excST4Bs');
        });
    }


    cancel(){
        this.props.history.push('/excST4Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcST4B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcST4B}>Save</button>
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

export default UpdateExcST4BComponent
