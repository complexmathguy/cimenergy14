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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * SynchronousMachineDetailed business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SynchronousMachineDetailed related services in the case of a
 *       SynchronousMachineDetailed business related service failing.
 *   <li>Exposes a simpler, uniform SynchronousMachineDetailed interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill SynchronousMachineDetailed
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SynchronousMachineDetailedBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SynchronousMachineDetailedBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SynchronousMachineDetailed Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SynchronousMachineDetailedBusinessDelegate
   */
  public static SynchronousMachineDetailedBusinessDelegate getSynchronousMachineDetailedInstance() {
    return (new SynchronousMachineDetailedBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSynchronousMachineDetailed(
      CreateSynchronousMachineDetailedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSynchronousMachineDetailedId() == null)
        command.setSynchronousMachineDetailedId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineDetailedValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSynchronousMachineDetailedCommand - by convention the future return value
      // for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSynchronousMachineDetailedCommand of SynchronousMachineDetailed is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SynchronousMachineDetailed - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSynchronousMachineDetailedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSynchronousMachineDetailed(
      UpdateSynchronousMachineDetailedCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SynchronousMachineDetailedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSynchronousMachineDetailedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SynchronousMachineDetailed - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSynchronousMachineDetailedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSynchronousMachineDetailedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineDetailedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSynchronousMachineDetailedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete SynchronousMachineDetailed using Id = "
              + command.getSynchronousMachineDetailedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SynchronousMachineDetailed via SynchronousMachineDetailedFetchOneSummary
   *
   * @param summary SynchronousMachineDetailedFetchOneSummary
   * @return SynchronousMachineDetailedFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SynchronousMachineDetailed getSynchronousMachineDetailed(
      SynchronousMachineDetailedFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "SynchronousMachineDetailedFetchOneSummary arg cannot be null");

    SynchronousMachineDetailed entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SynchronousMachineDetailedValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SynchronousMachineDetailed
      // --------------------------------------
      CompletableFuture<SynchronousMachineDetailed> futureEntity =
          queryGateway.query(
              new FindSynchronousMachineDetailedQuery(
                  new LoadSynchronousMachineDetailedFilter(
                      summary.getSynchronousMachineDetailedId())),
              ResponseTypes.instanceOf(SynchronousMachineDetailed.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate SynchronousMachineDetailed with id "
              + summary.getSynchronousMachineDetailedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SynchronousMachineDetaileds
   *
   * @return List<SynchronousMachineDetailed>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SynchronousMachineDetailed> getAllSynchronousMachineDetailed()
      throws ProcessingException {
    List<SynchronousMachineDetailed> list = null;

    try {
      CompletableFuture<List<SynchronousMachineDetailed>> futureList =
          queryGateway.query(
              new FindAllSynchronousMachineDetailedQuery(),
              ResponseTypes.multipleInstancesOf(SynchronousMachineDetailed.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SynchronousMachineDetailed";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign EfdBaseRatio on SynchronousMachineDetailed
   *
   * @param command AssignEfdBaseRatioToSynchronousMachineDetailedCommand
   * @exception ProcessingException
   */
  public void assignEfdBaseRatio(AssignEfdBaseRatioToSynchronousMachineDetailedCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineDetailedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    SynchronousMachineDetailedBusinessDelegate parentDelegate =
        SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineDetailedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign EfdBaseRatio on SynchronousMachineDetailed
   *
   * @param command UnAssignEfdBaseRatioFromSynchronousMachineDetailedCommand
   * @exception ProcessingException
   */
  public void unAssignEfdBaseRatio(
      UnAssignEfdBaseRatioFromSynchronousMachineDetailedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineDetailedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EfdBaseRatio on SynchronousMachineDetailed";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign IfdBaseValue on SynchronousMachineDetailed
   *
   * @param command AssignIfdBaseValueToSynchronousMachineDetailedCommand
   * @exception ProcessingException
   */
  public void assignIfdBaseValue(AssignIfdBaseValueToSynchronousMachineDetailedCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineDetailedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .CurrentFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .CurrentFlowBusinessDelegate.getCurrentFlowInstance();
    SynchronousMachineDetailedBusinessDelegate parentDelegate =
        SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance();
    UUID childId = command.getAssignment().getCurrentFlowId();
    CurrentFlow child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineDetailedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get CurrentFlow using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign IfdBaseValue on SynchronousMachineDetailed
   *
   * @param command UnAssignIfdBaseValueFromSynchronousMachineDetailedCommand
   * @exception ProcessingException
   */
  public void unAssignIfdBaseValue(
      UnAssignIfdBaseValueFromSynchronousMachineDetailedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineDetailedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign IfdBaseValue on SynchronousMachineDetailed";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SaturationFactor120QAxis on SynchronousMachineDetailed
   *
   * @param command AssignSaturationFactor120QAxisToSynchronousMachineDetailedCommand
   * @exception ProcessingException
   */
  public void assignSaturationFactor120QAxis(
      AssignSaturationFactor120QAxisToSynchronousMachineDetailedCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineDetailedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    SynchronousMachineDetailedBusinessDelegate parentDelegate =
        SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineDetailedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign SaturationFactor120QAxis on SynchronousMachineDetailed
   *
   * @param command UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedCommand
   * @exception ProcessingException
   */
  public void unAssignSaturationFactor120QAxis(
      UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineDetailedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to unassign SaturationFactor120QAxis on SynchronousMachineDetailed";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SaturationFactorQAxis on SynchronousMachineDetailed
   *
   * @param command AssignSaturationFactorQAxisToSynchronousMachineDetailedCommand
   * @exception ProcessingException
   */
  public void assignSaturationFactorQAxis(
      AssignSaturationFactorQAxisToSynchronousMachineDetailedCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineDetailedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    SynchronousMachineDetailedBusinessDelegate parentDelegate =
        SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineDetailedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign SaturationFactorQAxis on SynchronousMachineDetailed
   *
   * @param command UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedCommand
   * @exception ProcessingException
   */
  public void unAssignSaturationFactorQAxis(
      UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineDetailedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SaturationFactorQAxis on SynchronousMachineDetailed";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return SynchronousMachineDetailed
   */
  private SynchronousMachineDetailed load(UUID id) throws ProcessingException {
    synchronousMachineDetailed =
        SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance()
            .getSynchronousMachineDetailed(new SynchronousMachineDetailedFetchOneSummary(id));
    return synchronousMachineDetailed;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SynchronousMachineDetailed synchronousMachineDetailed = null;
  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineDetailedBusinessDelegate.class.getName());
}
