import React, { Component } from 'react'
import ExcST6BService from '../services/ExcST6BService';

class UpdateExcST6BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                oelin: ''
        }
        this.updateExcST6B = this.updateExcST6B.bind(this);

        this.changeOelinHandler = this.changeOelinHandler.bind(this);
    }

    componentDidMount(){
        ExcST6BService.getExcST6BById(this.state.id).then( (res) =>{
            let excST6B = res.data;
            this.setState({
                oelin: excST6B.oelin
            });
        });
    }

    updateExcST6B = (e) => {
        e.preventDefault();
        let excST6B = {
            excST6BId: this.state.id,
            oelin: this.state.oelin
        };
        console.log('excST6B => ' + JSON.stringify(excST6B));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcST6BService.updateExcST6B(excST6B).then( res => {
            this.props.history.push('/excST6Bs');
        });
    }

    changeOelinHandler= (event) => {
        this.setState({oelin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excST6Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcST6B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Oelin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcST6B}>Save</button>
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

export default UpdateExcST6BComponent
