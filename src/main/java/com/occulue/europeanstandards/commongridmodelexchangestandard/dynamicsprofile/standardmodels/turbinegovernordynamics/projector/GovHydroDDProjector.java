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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for GovHydroDD as outlined for the CQRS pattern. All event handling and query handling
 * related to GovHydroDD are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovHydroDDAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govHydroDD")
@Component("govHydroDD-projector")
public class GovHydroDDProjector extends GovHydroDDEntityProjector {

  // core constructor
  public GovHydroDDProjector(
      GovHydroDDRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovHydroDDEvent
   */
  @EventHandler(payloadType = CreateGovHydroDDEvent.class)
  public void handle(CreateGovHydroDDEvent event) {
    LOGGER.info("handling CreateGovHydroDDEvent - " + event);
    GovHydroDD entity = new GovHydroDD();
    entity.setGovHydroDDId(event.getGovHydroDDId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UpdateGovHydroDDEvent
   */
  @EventHandler(payloadType = UpdateGovHydroDDEvent.class)
  public void handle(UpdateGovHydroDDEvent event) {
    LOGGER.info("handling UpdateGovHydroDDEvent - " + event);

    GovHydroDD entity = new GovHydroDD();
    entity.setGovHydroDDId(event.getGovHydroDDId());
    entity.setAturb(event.getAturb());
    entity.setBturb(event.getBturb());
    entity.setDb1(event.getDb1());
    entity.setDb2(event.getDb2());
    entity.setEps(event.getEps());
    entity.setGmax(event.getGmax());
    entity.setGmin(event.getGmin());
    entity.setGv1(event.getGv1());
    entity.setGv2(event.getGv2());
    entity.setGv3(event.getGv3());
    entity.setGv4(event.getGv4());
    entity.setGv5(event.getGv5());
    entity.setGv6(event.getGv6());
    entity.setInputSignal(event.getInputSignal());
    entity.setK1(event.getK1());
    entity.setK2(event.getK2());
    entity.setKg(event.getKg());
    entity.setKi(event.getKi());
    entity.setMwbase(event.getMwbase());
    entity.setPgv1(event.getPgv1());
    entity.setPgv2(event.getPgv2());
    entity.setPgv3(event.getPgv3());
    entity.setPgv4(event.getPgv4());
    entity.setPgv5(event.getPgv5());
    entity.setPgv6(event.getPgv6());
    entity.setPmax(event.getPmax());
    entity.setPmin(event.getPmin());
    entity.setR(event.getR());
    entity.setTd(event.getTd());
    entity.setTf(event.getTf());
    entity.setTp(event.getTp());
    entity.setTt(event.getTt());
    entity.setTturb(event.getTturb());
    entity.setVelcl(event.getVelcl());
    entity.setVelop(event.getVelop());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event DeleteGovHydroDDEvent
   */
  @EventHandler(payloadType = DeleteGovHydroDDEvent.class)
  public void handle(DeleteGovHydroDDEvent event) {
    LOGGER.info("handling DeleteGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovHydroDD entity = delete(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignAturbToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignAturbToGovHydroDDEvent.class)
  public void handle(AssignAturbToGovHydroDDEvent event) {
    LOGGER.info("handling AssignAturbToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignAturb(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignAturbFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignAturbFromGovHydroDDEvent.class)
  public void handle(UnAssignAturbFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignAturbFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignAturb(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignBturbToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignBturbToGovHydroDDEvent.class)
  public void handle(AssignBturbToGovHydroDDEvent event) {
    LOGGER.info("handling AssignBturbToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignBturb(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignBturbFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignBturbFromGovHydroDDEvent.class)
  public void handle(UnAssignBturbFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignBturbFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignBturb(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignDb1ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignDb1ToGovHydroDDEvent.class)
  public void handle(AssignDb1ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignDb1ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignDb1(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignDb1FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignDb1FromGovHydroDDEvent.class)
  public void handle(UnAssignDb1FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignDb1FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignDb1(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignDb2ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignDb2ToGovHydroDDEvent.class)
  public void handle(AssignDb2ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignDb2ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignDb2(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignDb2FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignDb2FromGovHydroDDEvent.class)
  public void handle(UnAssignDb2FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignDb2FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignDb2(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignEpsToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignEpsToGovHydroDDEvent.class)
  public void handle(AssignEpsToGovHydroDDEvent event) {
    LOGGER.info("handling AssignEpsToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignEps(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignEpsFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignEpsFromGovHydroDDEvent.class)
  public void handle(UnAssignEpsFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignEpsFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignEps(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignGmaxToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignGmaxToGovHydroDDEvent.class)
  public void handle(AssignGmaxToGovHydroDDEvent event) {
    LOGGER.info("handling AssignGmaxToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignGmax(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignGmaxFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignGmaxFromGovHydroDDEvent.class)
  public void handle(UnAssignGmaxFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignGmaxFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignGmax(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignGminToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignGminToGovHydroDDEvent.class)
  public void handle(AssignGminToGovHydroDDEvent event) {
    LOGGER.info("handling AssignGminToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignGmin(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignGminFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignGminFromGovHydroDDEvent.class)
  public void handle(UnAssignGminFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignGminFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignGmin(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignGv1ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignGv1ToGovHydroDDEvent.class)
  public void handle(AssignGv1ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignGv1ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignGv1(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignGv1FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignGv1FromGovHydroDDEvent.class)
  public void handle(UnAssignGv1FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignGv1FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignGv1(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignGv2ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignGv2ToGovHydroDDEvent.class)
  public void handle(AssignGv2ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignGv2ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignGv2(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignGv2FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignGv2FromGovHydroDDEvent.class)
  public void handle(UnAssignGv2FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignGv2FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignGv2(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignGv3ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignGv3ToGovHydroDDEvent.class)
  public void handle(AssignGv3ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignGv3ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignGv3(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignGv3FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignGv3FromGovHydroDDEvent.class)
  public void handle(UnAssignGv3FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignGv3FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignGv3(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignGv4ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignGv4ToGovHydroDDEvent.class)
  public void handle(AssignGv4ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignGv4ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignGv4(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignGv4FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignGv4FromGovHydroDDEvent.class)
  public void handle(UnAssignGv4FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignGv4FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignGv4(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignGv5ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignGv5ToGovHydroDDEvent.class)
  public void handle(AssignGv5ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignGv5ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignGv5(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignGv5FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignGv5FromGovHydroDDEvent.class)
  public void handle(UnAssignGv5FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignGv5FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignGv5(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignGv6ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignGv6ToGovHydroDDEvent.class)
  public void handle(AssignGv6ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignGv6ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignGv6(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignGv6FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignGv6FromGovHydroDDEvent.class)
  public void handle(UnAssignGv6FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignGv6FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignGv6(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignInputSignalToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignInputSignalToGovHydroDDEvent.class)
  public void handle(AssignInputSignalToGovHydroDDEvent event) {
    LOGGER.info("handling AssignInputSignalToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignInputSignal(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignInputSignalFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignInputSignalFromGovHydroDDEvent.class)
  public void handle(UnAssignInputSignalFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignInputSignalFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignInputSignal(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignK1ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignK1ToGovHydroDDEvent.class)
  public void handle(AssignK1ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignK1ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignK1(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignK1FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignK1FromGovHydroDDEvent.class)
  public void handle(UnAssignK1FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignK1FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignK1(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignK2ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignK2ToGovHydroDDEvent.class)
  public void handle(AssignK2ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignK2ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignK2(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignK2FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignK2FromGovHydroDDEvent.class)
  public void handle(UnAssignK2FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignK2FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignK2(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignKgToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignKgToGovHydroDDEvent.class)
  public void handle(AssignKgToGovHydroDDEvent event) {
    LOGGER.info("handling AssignKgToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignKg(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignKgFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignKgFromGovHydroDDEvent.class)
  public void handle(UnAssignKgFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignKgFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignKg(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignKiToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignKiToGovHydroDDEvent.class)
  public void handle(AssignKiToGovHydroDDEvent event) {
    LOGGER.info("handling AssignKiToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignKi(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignKiFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignKiFromGovHydroDDEvent.class)
  public void handle(UnAssignKiFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignKiFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignKi(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignMwbaseToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignMwbaseToGovHydroDDEvent.class)
  public void handle(AssignMwbaseToGovHydroDDEvent event) {
    LOGGER.info("handling AssignMwbaseToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignMwbase(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovHydroDDEvent.class)
  public void handle(UnAssignMwbaseFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignMwbaseFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignMwbase(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignPgv1ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignPgv1ToGovHydroDDEvent.class)
  public void handle(AssignPgv1ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignPgv1ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignPgv1(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignPgv1FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignPgv1FromGovHydroDDEvent.class)
  public void handle(UnAssignPgv1FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignPgv1FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignPgv1(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignPgv2ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignPgv2ToGovHydroDDEvent.class)
  public void handle(AssignPgv2ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignPgv2ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignPgv2(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignPgv2FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignPgv2FromGovHydroDDEvent.class)
  public void handle(UnAssignPgv2FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignPgv2FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignPgv2(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignPgv3ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignPgv3ToGovHydroDDEvent.class)
  public void handle(AssignPgv3ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignPgv3ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignPgv3(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignPgv3FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignPgv3FromGovHydroDDEvent.class)
  public void handle(UnAssignPgv3FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignPgv3FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignPgv3(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignPgv4ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignPgv4ToGovHydroDDEvent.class)
  public void handle(AssignPgv4ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignPgv4ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignPgv4(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignPgv4FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignPgv4FromGovHydroDDEvent.class)
  public void handle(UnAssignPgv4FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignPgv4FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignPgv4(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignPgv5ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignPgv5ToGovHydroDDEvent.class)
  public void handle(AssignPgv5ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignPgv5ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignPgv5(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignPgv5FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignPgv5FromGovHydroDDEvent.class)
  public void handle(UnAssignPgv5FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignPgv5FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignPgv5(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignPgv6ToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignPgv6ToGovHydroDDEvent.class)
  public void handle(AssignPgv6ToGovHydroDDEvent event) {
    LOGGER.info("handling AssignPgv6ToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignPgv6(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignPgv6FromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignPgv6FromGovHydroDDEvent.class)
  public void handle(UnAssignPgv6FromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignPgv6FromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignPgv6(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignPmaxToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignPmaxToGovHydroDDEvent.class)
  public void handle(AssignPmaxToGovHydroDDEvent event) {
    LOGGER.info("handling AssignPmaxToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignPmax(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignPmaxFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignPmaxFromGovHydroDDEvent.class)
  public void handle(UnAssignPmaxFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignPmaxFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignPmax(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignPminToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignPminToGovHydroDDEvent.class)
  public void handle(AssignPminToGovHydroDDEvent event) {
    LOGGER.info("handling AssignPminToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignPmin(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignPminFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignPminFromGovHydroDDEvent.class)
  public void handle(UnAssignPminFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignPminFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignPmin(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignRToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignRToGovHydroDDEvent.class)
  public void handle(AssignRToGovHydroDDEvent event) {
    LOGGER.info("handling AssignRToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignR(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignRFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignRFromGovHydroDDEvent.class)
  public void handle(UnAssignRFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignRFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignR(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignTdToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignTdToGovHydroDDEvent.class)
  public void handle(AssignTdToGovHydroDDEvent event) {
    LOGGER.info("handling AssignTdToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignTd(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignTdFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignTdFromGovHydroDDEvent.class)
  public void handle(UnAssignTdFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignTdFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignTd(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignTfToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignTfToGovHydroDDEvent.class)
  public void handle(AssignTfToGovHydroDDEvent event) {
    LOGGER.info("handling AssignTfToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignTf(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignTfFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignTfFromGovHydroDDEvent.class)
  public void handle(UnAssignTfFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignTfFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignTf(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignTpToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignTpToGovHydroDDEvent.class)
  public void handle(AssignTpToGovHydroDDEvent event) {
    LOGGER.info("handling AssignTpToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignTp(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignTpFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignTpFromGovHydroDDEvent.class)
  public void handle(UnAssignTpFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignTpFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignTp(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignTtToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignTtToGovHydroDDEvent.class)
  public void handle(AssignTtToGovHydroDDEvent event) {
    LOGGER.info("handling AssignTtToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignTt(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignTtFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignTtFromGovHydroDDEvent.class)
  public void handle(UnAssignTtFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignTtFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignTt(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignTturbToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignTturbToGovHydroDDEvent.class)
  public void handle(AssignTturbToGovHydroDDEvent event) {
    LOGGER.info("handling AssignTturbToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignTturb(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignTturbFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignTturbFromGovHydroDDEvent.class)
  public void handle(UnAssignTturbFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignTturbFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignTturb(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignVelclToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignVelclToGovHydroDDEvent.class)
  public void handle(AssignVelclToGovHydroDDEvent event) {
    LOGGER.info("handling AssignVelclToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignVelcl(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignVelclFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignVelclFromGovHydroDDEvent.class)
  public void handle(UnAssignVelclFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignVelclFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignVelcl(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event AssignVelopToGovHydroDDEvent
   */
  @EventHandler(payloadType = AssignVelopToGovHydroDDEvent.class)
  public void handle(AssignVelopToGovHydroDDEvent event) {
    LOGGER.info("handling AssignVelopToGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroDD entity = assignVelop(event.getGovHydroDDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /*
   * @param	event UnAssignVelopFromGovHydroDDEvent
   */
  @EventHandler(payloadType = UnAssignVelopFromGovHydroDDEvent.class)
  public void handle(UnAssignVelopFromGovHydroDDEvent event) {
    LOGGER.info("handling UnAssignVelopFromGovHydroDDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroDD entity = unAssignVelop(event.getGovHydroDDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroDD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroDD(entity);
  }

  /**
   * Method to retrieve the GovHydroDD via an GovHydroDDPrimaryKey.
   *
   * @param id Long
   * @return GovHydroDD
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovHydroDD handle(FindGovHydroDDQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovHydroDDId());
  }

  /**
   * Method to retrieve a collection of all GovHydroDDs
   *
   * @param query FindAllGovHydroDDQuery
   * @return List<GovHydroDD>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovHydroDD> handle(FindAllGovHydroDDQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovHydroDD, but only if the id matches
   *
   * @param entity GovHydroDD
   */
  protected void emitFindGovHydroDD(GovHydroDD entity) {
    LOGGER.info("handling emitFindGovHydroDD");

    queryUpdateEmitter.emit(
        FindGovHydroDDQuery.class,
        query -> query.getFilter().getGovHydroDDId().equals(entity.getGovHydroDDId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovHydroDD
   *
   * @param entity GovHydroDD
   */
  protected void emitFindAllGovHydroDD(GovHydroDD entity) {
    LOGGER.info("handling emitFindAllGovHydroDD");

    queryUpdateEmitter.emit(FindAllGovHydroDDQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovHydroDDProjector.class.getName());
}
