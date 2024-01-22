/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcELIN1 as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcELIN1 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcELIN1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excELIN1")
@Component("excELIN1-projector")
public class ExcELIN1Projector extends ExcELIN1EntityProjector {

  // core constructor
  public ExcELIN1Projector(ExcELIN1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcELIN1Event
   */
  @EventHandler(payloadType = CreateExcELIN1Event.class)
  public void handle(CreateExcELIN1Event event) {
    LOGGER.info("handling CreateExcELIN1Event - " + event);
    ExcELIN1 entity = new ExcELIN1();
    entity.setExcELIN1Id(event.getExcELIN1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UpdateExcELIN1Event
   */
  @EventHandler(payloadType = UpdateExcELIN1Event.class)
  public void handle(UpdateExcELIN1Event event) {
    LOGGER.info("handling UpdateExcELIN1Event - " + event);

    ExcELIN1 entity = new ExcELIN1();
    entity.setExcELIN1Id(event.getExcELIN1Id());
    entity.setDpnf(event.getDpnf());
    entity.setEfmax(event.getEfmax());
    entity.setEfmin(event.getEfmin());
    entity.setKs1(event.getKs1());
    entity.setKs2(event.getKs2());
    entity.setSmax(event.getSmax());
    entity.setTfi(event.getTfi());
    entity.setTnu(event.getTnu());
    entity.setTs1(event.getTs1());
    entity.setTs2(event.getTs2());
    entity.setTsw(event.getTsw());
    entity.setVpi(event.getVpi());
    entity.setVpnf(event.getVpnf());
    entity.setVpu(event.getVpu());
    entity.setXe(event.getXe());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event DeleteExcELIN1Event
   */
  @EventHandler(payloadType = DeleteExcELIN1Event.class)
  public void handle(DeleteExcELIN1Event event) {
    LOGGER.info("handling DeleteExcELIN1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcELIN1 entity = delete(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event AssignDpnfToExcELIN1Event
   */
  @EventHandler(payloadType = AssignDpnfToExcELIN1Event.class)
  public void handle(AssignDpnfToExcELIN1Event event) {
    LOGGER.info("handling AssignDpnfToExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN1 entity = assignDpnf(event.getExcELIN1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UnAssignDpnfFromExcELIN1Event
   */
  @EventHandler(payloadType = UnAssignDpnfFromExcELIN1Event.class)
  public void handle(UnAssignDpnfFromExcELIN1Event event) {
    LOGGER.info("handling UnAssignDpnfFromExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN1 entity = unAssignDpnf(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event AssignEfmaxToExcELIN1Event
   */
  @EventHandler(payloadType = AssignEfmaxToExcELIN1Event.class)
  public void handle(AssignEfmaxToExcELIN1Event event) {
    LOGGER.info("handling AssignEfmaxToExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN1 entity = assignEfmax(event.getExcELIN1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UnAssignEfmaxFromExcELIN1Event
   */
  @EventHandler(payloadType = UnAssignEfmaxFromExcELIN1Event.class)
  public void handle(UnAssignEfmaxFromExcELIN1Event event) {
    LOGGER.info("handling UnAssignEfmaxFromExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN1 entity = unAssignEfmax(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event AssignEfminToExcELIN1Event
   */
  @EventHandler(payloadType = AssignEfminToExcELIN1Event.class)
  public void handle(AssignEfminToExcELIN1Event event) {
    LOGGER.info("handling AssignEfminToExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN1 entity = assignEfmin(event.getExcELIN1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UnAssignEfminFromExcELIN1Event
   */
  @EventHandler(payloadType = UnAssignEfminFromExcELIN1Event.class)
  public void handle(UnAssignEfminFromExcELIN1Event event) {
    LOGGER.info("handling UnAssignEfminFromExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN1 entity = unAssignEfmin(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event AssignKs1ToExcELIN1Event
   */
  @EventHandler(payloadType = AssignKs1ToExcELIN1Event.class)
  public void handle(AssignKs1ToExcELIN1Event event) {
    LOGGER.info("handling AssignKs1ToExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN1 entity = assignKs1(event.getExcELIN1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UnAssignKs1FromExcELIN1Event
   */
  @EventHandler(payloadType = UnAssignKs1FromExcELIN1Event.class)
  public void handle(UnAssignKs1FromExcELIN1Event event) {
    LOGGER.info("handling UnAssignKs1FromExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN1 entity = unAssignKs1(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event AssignKs2ToExcELIN1Event
   */
  @EventHandler(payloadType = AssignKs2ToExcELIN1Event.class)
  public void handle(AssignKs2ToExcELIN1Event event) {
    LOGGER.info("handling AssignKs2ToExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN1 entity = assignKs2(event.getExcELIN1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UnAssignKs2FromExcELIN1Event
   */
  @EventHandler(payloadType = UnAssignKs2FromExcELIN1Event.class)
  public void handle(UnAssignKs2FromExcELIN1Event event) {
    LOGGER.info("handling UnAssignKs2FromExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN1 entity = unAssignKs2(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event AssignSmaxToExcELIN1Event
   */
  @EventHandler(payloadType = AssignSmaxToExcELIN1Event.class)
  public void handle(AssignSmaxToExcELIN1Event event) {
    LOGGER.info("handling AssignSmaxToExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN1 entity = assignSmax(event.getExcELIN1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UnAssignSmaxFromExcELIN1Event
   */
  @EventHandler(payloadType = UnAssignSmaxFromExcELIN1Event.class)
  public void handle(UnAssignSmaxFromExcELIN1Event event) {
    LOGGER.info("handling UnAssignSmaxFromExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN1 entity = unAssignSmax(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event AssignTfiToExcELIN1Event
   */
  @EventHandler(payloadType = AssignTfiToExcELIN1Event.class)
  public void handle(AssignTfiToExcELIN1Event event) {
    LOGGER.info("handling AssignTfiToExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN1 entity = assignTfi(event.getExcELIN1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UnAssignTfiFromExcELIN1Event
   */
  @EventHandler(payloadType = UnAssignTfiFromExcELIN1Event.class)
  public void handle(UnAssignTfiFromExcELIN1Event event) {
    LOGGER.info("handling UnAssignTfiFromExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN1 entity = unAssignTfi(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event AssignTnuToExcELIN1Event
   */
  @EventHandler(payloadType = AssignTnuToExcELIN1Event.class)
  public void handle(AssignTnuToExcELIN1Event event) {
    LOGGER.info("handling AssignTnuToExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN1 entity = assignTnu(event.getExcELIN1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UnAssignTnuFromExcELIN1Event
   */
  @EventHandler(payloadType = UnAssignTnuFromExcELIN1Event.class)
  public void handle(UnAssignTnuFromExcELIN1Event event) {
    LOGGER.info("handling UnAssignTnuFromExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN1 entity = unAssignTnu(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event AssignTs1ToExcELIN1Event
   */
  @EventHandler(payloadType = AssignTs1ToExcELIN1Event.class)
  public void handle(AssignTs1ToExcELIN1Event event) {
    LOGGER.info("handling AssignTs1ToExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN1 entity = assignTs1(event.getExcELIN1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UnAssignTs1FromExcELIN1Event
   */
  @EventHandler(payloadType = UnAssignTs1FromExcELIN1Event.class)
  public void handle(UnAssignTs1FromExcELIN1Event event) {
    LOGGER.info("handling UnAssignTs1FromExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN1 entity = unAssignTs1(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event AssignTs2ToExcELIN1Event
   */
  @EventHandler(payloadType = AssignTs2ToExcELIN1Event.class)
  public void handle(AssignTs2ToExcELIN1Event event) {
    LOGGER.info("handling AssignTs2ToExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN1 entity = assignTs2(event.getExcELIN1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UnAssignTs2FromExcELIN1Event
   */
  @EventHandler(payloadType = UnAssignTs2FromExcELIN1Event.class)
  public void handle(UnAssignTs2FromExcELIN1Event event) {
    LOGGER.info("handling UnAssignTs2FromExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN1 entity = unAssignTs2(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event AssignTswToExcELIN1Event
   */
  @EventHandler(payloadType = AssignTswToExcELIN1Event.class)
  public void handle(AssignTswToExcELIN1Event event) {
    LOGGER.info("handling AssignTswToExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN1 entity = assignTsw(event.getExcELIN1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UnAssignTswFromExcELIN1Event
   */
  @EventHandler(payloadType = UnAssignTswFromExcELIN1Event.class)
  public void handle(UnAssignTswFromExcELIN1Event event) {
    LOGGER.info("handling UnAssignTswFromExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN1 entity = unAssignTsw(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event AssignVpiToExcELIN1Event
   */
  @EventHandler(payloadType = AssignVpiToExcELIN1Event.class)
  public void handle(AssignVpiToExcELIN1Event event) {
    LOGGER.info("handling AssignVpiToExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN1 entity = assignVpi(event.getExcELIN1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UnAssignVpiFromExcELIN1Event
   */
  @EventHandler(payloadType = UnAssignVpiFromExcELIN1Event.class)
  public void handle(UnAssignVpiFromExcELIN1Event event) {
    LOGGER.info("handling UnAssignVpiFromExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN1 entity = unAssignVpi(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event AssignVpnfToExcELIN1Event
   */
  @EventHandler(payloadType = AssignVpnfToExcELIN1Event.class)
  public void handle(AssignVpnfToExcELIN1Event event) {
    LOGGER.info("handling AssignVpnfToExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN1 entity = assignVpnf(event.getExcELIN1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UnAssignVpnfFromExcELIN1Event
   */
  @EventHandler(payloadType = UnAssignVpnfFromExcELIN1Event.class)
  public void handle(UnAssignVpnfFromExcELIN1Event event) {
    LOGGER.info("handling UnAssignVpnfFromExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN1 entity = unAssignVpnf(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event AssignVpuToExcELIN1Event
   */
  @EventHandler(payloadType = AssignVpuToExcELIN1Event.class)
  public void handle(AssignVpuToExcELIN1Event event) {
    LOGGER.info("handling AssignVpuToExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN1 entity = assignVpu(event.getExcELIN1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UnAssignVpuFromExcELIN1Event
   */
  @EventHandler(payloadType = UnAssignVpuFromExcELIN1Event.class)
  public void handle(UnAssignVpuFromExcELIN1Event event) {
    LOGGER.info("handling UnAssignVpuFromExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN1 entity = unAssignVpu(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event AssignXeToExcELIN1Event
   */
  @EventHandler(payloadType = AssignXeToExcELIN1Event.class)
  public void handle(AssignXeToExcELIN1Event event) {
    LOGGER.info("handling AssignXeToExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN1 entity = assignXe(event.getExcELIN1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /*
   * @param	event UnAssignXeFromExcELIN1Event
   */
  @EventHandler(payloadType = UnAssignXeFromExcELIN1Event.class)
  public void handle(UnAssignXeFromExcELIN1Event event) {
    LOGGER.info("handling UnAssignXeFromExcELIN1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN1 entity = unAssignXe(event.getExcELIN1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN1(entity);
  }

  /**
   * Method to retrieve the ExcELIN1 via an ExcELIN1PrimaryKey.
   *
   * @param id Long
   * @return ExcELIN1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcELIN1 handle(FindExcELIN1Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcELIN1Id());
  }

  /**
   * Method to retrieve a collection of all ExcELIN1s
   *
   * @param query FindAllExcELIN1Query
   * @return List<ExcELIN1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcELIN1> handle(FindAllExcELIN1Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcELIN1, but only if the id matches
   *
   * @param entity ExcELIN1
   */
  protected void emitFindExcELIN1(ExcELIN1 entity) {
    LOGGER.info("handling emitFindExcELIN1");

    queryUpdateEmitter.emit(
        FindExcELIN1Query.class,
        query -> query.getFilter().getExcELIN1Id().equals(entity.getExcELIN1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcELIN1
   *
   * @param entity ExcELIN1
   */
  protected void emitFindAllExcELIN1(ExcELIN1 entity) {
    LOGGER.info("handling emitFindAllExcELIN1");

    queryUpdateEmitter.emit(FindAllExcELIN1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcELIN1Projector.class.getName());
}
